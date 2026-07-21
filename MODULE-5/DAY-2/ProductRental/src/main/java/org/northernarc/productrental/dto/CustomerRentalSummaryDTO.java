package org.northernarc.productrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRentalSummaryDTO{
        String customerName;
        String city;
        Long numberOfRentals;
        Double totalRentPaid;

        public CustomerRentalSummaryDTO(String customerName,
                                        String city,
                                        Long numberOfRentals,
                                        Double totalRentPaid) {
                this.customerName = customerName;
                this.city = city;
                this.numberOfRentals = numberOfRentals;
                this.totalRentPaid = totalRentPaid;
        }

}
