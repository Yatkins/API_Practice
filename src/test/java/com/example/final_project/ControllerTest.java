package com.example.final_project;

import com.example.final_project.controller.ProjectController;
import com.example.final_project.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FinalControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController subject;

    @Test
    public void getTime_callService_returnResults()
    {
        when(projectService.getTime()).thenReturn(new ResponseEntity(Timestamp.valueOf("2020-12-31 12:59:59.9999999"), HttpStatus.OK));
        ResponseEntity actual = subject.getTime();
        verify(projectService).getTime();
        ResponseEntity expected = new ResponseEntity(Timestamp.valueOf("2020-12-31 12:59:59.9999999"), HttpStatus.OK);
        assertThat(actual).isEqualTo(expected);
    }
}