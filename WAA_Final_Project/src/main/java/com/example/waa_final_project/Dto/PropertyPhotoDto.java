package com.example.waa_final_project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPhotoDto {

    private long id;
    private byte[] image;
}
