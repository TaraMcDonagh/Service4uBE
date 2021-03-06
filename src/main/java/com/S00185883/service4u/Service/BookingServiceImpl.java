package com.S00185883.service4u.Service;

import com.S00185883.service4u.Repository.BookingRepository;
import com.S00185883.service4u.Repository.ProvidersRepository;
import com.S00185883.service4u.model.Booking;
import com.S00185883.service4u.model.Provider;
import com.S00185883.service4u.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);    }

    @Override
    public List<Booking> fetchBookingList() {
        return (List<Booking>)
                bookingRepository.findAll();     }

    @Override
    public Booking updateBooking(Booking booking, Long bookingId) {
        Booking depDB
                = bookingRepository.findById(bookingId)
                .get();


        if (Objects.nonNull(
                booking.getProviderId())
                && !"".equalsIgnoreCase(
                String.valueOf(booking.getProviderId()))) {
            depDB.setProviderId(
                    booking.getProviderId());
        }
        if (Objects.nonNull(
                booking.getCustomer())
                && !"".equalsIgnoreCase(
                String.valueOf(booking.getCustomer()))) {
            depDB.setCustomer(
                    booking.getCustomer());
        }
        if (Objects.nonNull(
                booking.getServiceId())
                && !"".equalsIgnoreCase(
                String.valueOf(booking.getServiceId()))) {
            depDB.setServiceId(
                    booking.getServiceId());
        }

        if (Objects.nonNull(booking.getLocation())
                && !"".equalsIgnoreCase(
                booking.getLocation())) {
            depDB.setLocation(
                    booking.getLocation());
        }
        if (Objects.nonNull(booking.getDate())
                && !"".equalsIgnoreCase(
                String.valueOf(booking.getDate()))) {
            depDB.setDate(
                    booking.getDate());
        }
        if (Objects.nonNull(booking.getTime())
                && !"".equalsIgnoreCase(
                String.valueOf(booking.getTime()))) {
            depDB.setTime(
                    booking.getTime());
        }

        return bookingRepository.save(depDB);    }

    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);

    }
    @Override
    public List<Booking> findByCustomer(String customeremail) {
        return (List<Booking>)
                bookingRepository.findByCustomer(customeremail);    }
}
