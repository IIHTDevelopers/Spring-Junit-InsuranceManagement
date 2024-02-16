package com.insurancepolicy;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.insurancepolicy.mainapp.CustomTestSummaryListener;

@SpringBootApplication
public class InsurancePolicyManagementApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
		.selectors(DiscoverySelectors.selectPackage("com.insurancepolicy.test"))
		.build();

		Launcher launcher = org.junit.platform.launcher.core.LauncherFactory.create();
		CustomTestSummaryListener listener = new CustomTestSummaryListener();

		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
	}
}
