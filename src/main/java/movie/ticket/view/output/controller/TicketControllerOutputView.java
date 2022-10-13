package movie.ticket.view.output.controller;

import movie.ticket.domain.customer.Customer;
import movie.ticket.domain.discount.CustomerDiscount;
import movie.ticket.domain.discount.factory.Discount;
import movie.ticket.domain.screen.Screen;
import movie.ticket.dto.customer.CustomersDto;
import movie.ticket.dto.movie.MovieDto;
import movie.ticket.dto.screen.ScreenDto;
import movie.ticket.dto.showtime.ShowTimeDto;
import movie.ticket.dto.ticket.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

import static movie.ticket.view.output.OutputView.print;
import static movie.ticket.view.output.UnitMessage.*;

public class TicketControllerOutputView {

    private static final String ANNOUNCE_TICKET_TEXT = "결제 내역 확인";
    private static final String TICKET_TEXT_MOVIE = "영화 : ";
    private static final String TICKET_TEXT_SHOWTIME = "시간 : ";
    private static final String TICKET_TEXT_DISCOUNT_HISTORY = "할인 내역 : ";
    private static final String TICKET_TEXT_TOTAL_PRICE = "총 결제 금액 : ";
    private static final String CUSTOMER_DISCOUNT = "인원 유형 할인 : ";
    private static final String COUPON_DISCOUNT = "할인 선택 할인 : ";
    private static final String DISCOUNT_MESSAGE = "할인 되었습니다.";

    public void responseTicketsContext(List<TicketDto> ticketDtos) {
        print(ticketsContextResponse(ticketDtos));
    }

    public String ticketsContextResponse(List<TicketDto> ticketDtos) {
        TicketDto ticketDto = ticketDtos.get(0);
        MovieDto ticketMovie = ticketDto.getMovie();
        ScreenDto ticketScreen = ticketDto.getScreen();
        ShowTimeDto ticketShowTime = ticketDto.getShowTime();
        Discount couponDiscount = ticketDto.getDiscount();

        List<List<CustomersDto>> gatheredByCustomerType = gatherCustomersByCustomerType(ticketDtos);
        int findMoviePrice = getMoviePrice(ticketScreen);
        int totalTicketPrice = getTotalTicketPrice(ticketDtos);
        int totalCouponDiscountedPrice = couponDiscount.discount(findMoviePrice).intValue() * ticketDtos.size();
        Integer totalCustomerDiscountPrice = totalTicketPrice;

        for (List<CustomersDto> customers : gatheredByCustomerType) {
            int customersSize = customers.size();
            if (customersSize != 0) {
                Long findId = customers.get(0).getId();
                Customer findCustomer = Customer.findCustomerById(findId);
                int discountedPrice = findMoviePrice - CustomerDiscount.discount(
                        findCustomer.loadCustomerDiscountType(),
                        findMoviePrice
                ) * customersSize;

                totalCustomerDiscountPrice -= discountedPrice;
            }
        }

        StringBuilder textBuilder = new StringBuilder();
        appendAnnounceText(textBuilder);
        appendMovieName(ticketMovie, textBuilder);
        appendShowTime(ticketShowTime, textBuilder);
        textBuilder.append(TICKET_TEXT_DISCOUNT_HISTORY).append(ENTER.unit);
        appendCustomerDiscountHistory(gatheredByCustomerType, findMoviePrice, textBuilder);
        appendCouponDiscountHistory(ticketDtos, couponDiscount, totalCouponDiscountedPrice, textBuilder);
        appendTotalTicketPrice(totalCustomerDiscountPrice, textBuilder);

        return textBuilder.toString();
    }

    private void appendTotalTicketPrice(int totalCustomerDiscountPrice, StringBuilder textBuilder) {
        textBuilder.append(TICKET_TEXT_TOTAL_PRICE)
                .append(totalCustomerDiscountPrice)
                .append(WON.unit)
                .append(ENTER.unit);
    }

    private void appendShowTime(ShowTimeDto ticketShowTime, StringBuilder textBuilder) {
        textBuilder.append(TICKET_TEXT_SHOWTIME)
                .append(ticketShowTime.getTime())
                .append(ENTER.unit);
    }

    private void appendMovieName(MovieDto ticketMovie, StringBuilder textBuilder) {
        textBuilder.append(TICKET_TEXT_MOVIE)
                .append(ticketMovie.getName())
                .append(ENTER.unit);
    }

    private void appendAnnounceText(StringBuilder textBuilder) {
        textBuilder.append(ANNOUNCE_TICKET_TEXT)
                .append(ENTER.unit);
    }

    private void appendCouponDiscountHistory(List<TicketDto> ticketDtos,
                                             Discount couponDiscount,
                                             int totalCouponDiscountPrice,
                                             StringBuilder textBuilder) {
        textBuilder.append(COUPON_DISCOUNT)
                .append(couponDiscount.loadDiscountName())
                .append(SPACE.unit)
                .append(ticketDtos.size())
                .append(PEOPLE_COUNT.unit)
                .append(SPACE.unit)
                .append(totalCouponDiscountPrice)
                .append(WON.unit)
                .append(ENTER.unit);
    }

    private void appendCustomerDiscountHistory(List<List<CustomersDto>> gatheredByCustomerType,
                                               int findMoviePrice,
                                               StringBuilder textBuilder) {
        textBuilder.append(CUSTOMER_DISCOUNT);
        gatheredByCustomerType.forEach(customers -> {
            int customersSize = customers.size();

            if (checkCustomerTypeExists(customersSize)) {
                Long findId = customers.get(0).getId();
                Customer findCustomer = Customer.findCustomerById(findId);
                int discountedPrice = findMoviePrice - CustomerDiscount.discount(
                        findCustomer.loadCustomerDiscountType(),
                        findMoviePrice
                ) * customersSize;

                textBuilder.append(customers.get(0).getName())
                        .append(SPACE.unit)
                        .append(customersSize)
                        .append(PEOPLE_COUNT.unit)
                        .append(SPACE.unit)
                        .append(discountedPrice)
                        .append(WON.unit)
                        .append(SPACE.unit)
                        .append(DISCOUNT_MESSAGE)
                        .append(SLASH.unit)
                        .append(SPACE.unit);
            }
        });
        textBuilder.append(ENTER.unit);

        int removeLastSlashIndex = textBuilder.lastIndexOf(SPACE.unit);
        textBuilder.delete(removeLastSlashIndex, removeLastSlashIndex + 1);
    }

    private Integer getMoviePrice(ScreenDto ticketScreen) {
        return Screen.findScreenById(ticketScreen.getId())
                .loadPrice();
    }

    private int getTotalTicketPrice(List<TicketDto> ticketDtos) {
        return ticketDtos.stream()
                .mapToInt(TicketDto::getPrice)
                .sum();
    }

    private boolean checkCustomerTypeExists(int customersSize) {
        return customersSize != 0;
    }

    private List<List<CustomersDto>> gatherCustomersByCustomerType(List<TicketDto> ticketDtos) {
        return Customer.findAllCustomers()
                .stream()
                .map(customer -> ticketDtos.stream()
                        .filter(ticket -> checkSameCustomer(customer, ticket))
                        .map(TicketDto::getCustomer)
                        .collect(Collectors.toUnmodifiableList()))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean checkSameCustomer(Customer customer, TicketDto ticket) {
        return customer.checkSameById(ticket.getCustomer().getId());
    }
}
