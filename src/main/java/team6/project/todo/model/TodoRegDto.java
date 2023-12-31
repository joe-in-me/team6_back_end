package team6.project.todo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

import static team6.project.common.Const.*;

@Data
@Schema(name = "투두 등록", title = "투두 등록")
public class TodoRegDto {

    @Schema(title = "유저 PK", minimum = "1", type = "Integer", description = "필수값", defaultValue = "1")
    @NotNull(message = BAD_INFO_EX_MESSAGE)
    @Range(min=1L, message = BAD_REQUEST_EX_MESSAGE)
    private Integer iuser;

    @Schema(title = "투두 제목", maximum = "100", type = "String", description = "필수값, 공백일 수 없음", defaultValue = "todoContent")
    @NotBlank(message = BAD_INFO_EX_MESSAGE)
    @Length(max=100, message = BAD_INFO_EX_MESSAGE)
    private String todoContent;

    @Schema(title = "일정 시작일", type = "String", description = "필수값", format = "yyyy-MM-dd", defaultValue = "2023-12-12")
    @NotNull(message = BAD_DATE_INFO_EX_MESSAGE)
    private LocalDate startDate;


    @Schema(title = "일정 종료일", type = "String", description = "필수값", defaultValue = "2023-12-13")
    @NotNull(message = BAD_DATE_INFO_EX_MESSAGE)
    private LocalDate endDate;

    @Schema(title = "일정 시작 시간", type = "String", defaultValue = "00:00:00",  format = "HH:mm:ss", hidden = false)
//    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Schema(title = "일정 종료 시간", type = "String", defaultValue = "23:59:59",  format = "HH:mm:ss", hidden = false)
//    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @Schema(title = "반복 종료 시간", type = "String", hidden = false)
    private LocalDate repeatEndDate;

    @Schema(title = "반복 종류 식별", type = "String", description = "주반복: week, 월반복: month", defaultValue = "week", hidden = false)
    private String repeatType;

    @Range(min = 0, max = 31, message = BAD_DATE_INFO_EX_MESSAGE)
    @Schema(title = "반복일 식별 숫자", type = "Integer", description = "주반복일 경우: 0~6 (0금 ~ 6목), 월반복일 경우: 1~31", defaultValue = "1", hidden = false)
    private Integer repeatNum;

}
