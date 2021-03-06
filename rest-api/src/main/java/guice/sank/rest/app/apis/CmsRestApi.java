package guice.sank.rest.app.apis;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import guice.sank.rest.app.domainObjects.sfdc.ProductOffer;
import guice.sank.rest.app.repositories.DataLoaderRepository;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value = "CmsOperations")
@Produces({MediaType.APPLICATION_JSON})
@Path("/cms")
public class CmsRestApi {

	@Inject
	private DataLoaderRepository dataLoaderRepository;

	@Path("/")
	@POST
	@ApiOperation(value = "Post product offer from SFDC to Magnolia CMS")
	public void postProductData(final ProductOffer productOffer) {
		dataLoaderRepository.postRequestToCms(productOffer);
	}
}
