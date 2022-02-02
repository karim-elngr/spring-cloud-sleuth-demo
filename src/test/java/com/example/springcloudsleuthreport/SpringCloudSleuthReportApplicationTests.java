package com.example.springcloudsleuthreport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.SpringApplication;

class SpringCloudSleuthReportApplicationTests {

	@Test
	void contextLoads_whenSpringCloudSleuthIsPresent_throwsBeanNotOfRequiredTypeException() {

		var exception = assertThrows(UnsatisfiedDependencyException.class,
				() -> SpringApplication.run(SpringCloudSleuthReportApplication.class));

		assertThat(exception).hasRootCauseExactlyInstanceOf(BeanNotOfRequiredTypeException.class)
				.hasMessageContaining("Bean named 'hikariDataSource' is expected to be of type 'com.zaxxer"
						+ ".hikari.HikariDataSource' but was actually of type 'org.springframework.cloud.sleuth"
						+ ".instrument.jdbc.DataSourceWrapper$$EnhancerBySpringCGLIB$$");
	}
}
