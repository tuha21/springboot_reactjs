package com.fpt.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeProfile {
    private String fullname;
    private String email;
    private String photo;
}
