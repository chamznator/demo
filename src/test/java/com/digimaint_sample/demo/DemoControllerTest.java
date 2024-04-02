package com.digimaint_sample.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.digimaint_sample.demo.controller.DemoController;

class DemoControllerTest {

    @Test
    public void videoPage_ShouldReturnVideoPage() {
        // Arrange
        DemoController controller = new DemoController();

        // Act
        String result = controller.videoPage();

        // Assert
        assertThat(result).isEqualTo("video");

        System.out.println("Test passed: " + result);
    }

}
