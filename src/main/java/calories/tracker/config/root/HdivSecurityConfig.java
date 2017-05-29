package calories.tracker.config.root;

import org.hdiv.config.annotation.ExclusionRegistry;
import org.hdiv.ee.config.annotation.ValidationConfigurer;
import org.springframework.context.annotation.Configuration;

import com.hdivsecurity.services.config.EnableHdiv4ServicesSecurityConfiguration;
import com.hdivsecurity.services.config.HdivServicesSecurityConfigurerAdapter;
import com.hdivsecurity.services.config.ServicesSecurityConfigBuilder;

@Configuration
@EnableHdiv4ServicesSecurityConfiguration
public class HdivSecurityConfig extends HdivServicesSecurityConfigurerAdapter {

	@Override
	public void configure(final ServicesSecurityConfigBuilder builder) {
		builder.confidentiality(false).sessionExpired().homePage("/");
		builder.showErrorPageOnEditableValidation(true);
		builder.hypermediaSupport(false).csrfHeader(false);
	}

	@Override
	public void addExclusions(final ExclusionRegistry registry) {
		registry.addUrlExclusions("/", "/favicon.ico", "/resources/.*");
	}

	@Override
	public void configureEditableValidation(final ValidationConfigurer validationConfigurer) {
		validationConfigurer.addValidation("/.*");
	}

}