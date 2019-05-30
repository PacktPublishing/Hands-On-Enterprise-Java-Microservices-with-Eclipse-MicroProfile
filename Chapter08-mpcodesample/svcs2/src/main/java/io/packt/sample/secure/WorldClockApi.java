package io.packt.sample.secure;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * http://worldclockapi.com/api/json/utc/now
 * {
 *   "$id": "1",
 *   "currentDateTime": "2019-04-25T03:23Z",
 *   "utcOffset": "00:00:00",
 *   "isDayLightSavingsTime": false,
 *   "dayOfTheWeek": "Thursday",
 *   "timeZoneName": "UTC",
 *   "currentFileTime": 132006362107999360,
 *   "ordinalDate": "2019-115",
 *   "serviceResponse": null
 * }
 */
@RegisterRestClient(baseUri = WorldClockApi.BASE_URL)
public interface WorldClockApi {
    static final String BASE_URL = "http://worldclockapi.com/api/json";

    @GET
    @Path("/utc/now")
    @Produces(MediaType.APPLICATION_JSON)
    Now utc();

    @GET
    @Path("{tz}/now")
    @Produces(MediaType.APPLICATION_JSON)
    Now tz(@PathParam("tz") String tz);
}
