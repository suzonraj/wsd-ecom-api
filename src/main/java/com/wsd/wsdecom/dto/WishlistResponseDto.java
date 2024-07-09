package com.wsd.wsdecom.dto;

import com.wsd.wsdecom.entity.Customer;
import com.wsd.wsdecom.entity.Item;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3663096980012553913L;

    private Long customerId;
    private List<WishlistItemDto> items;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class WishlistItemDto{
        private Item item;
        private LocalDateTime addedAt;
    }
}
