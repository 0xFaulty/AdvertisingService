package cloud.adservice.controller;

import cloud.adservice.model.api.ApiError;
import cloud.adservice.model.infrastructure.Metro;
import cloud.adservice.model.infrastructure.Shop;
import cloud.adservice.model.mappoint.WeightMapPoint;
import cloud.adservice.model.population.House;
import cloud.adservice.model.population.People;
import cloud.adservice.model.route.WeightRoute;
import cloud.adservice.service.ad.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class AdController {

    private final static Logger LOG = LoggerFactory.getLogger(AdController.class);

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/bo/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBestAdPoint(@PathVariable String category) {
        List<WeightMapPoint> areaPointList;
        try {
            areaPointList = adService.getBestAdPoint(category);
            if (areaPointList != null)
                return new ResponseEntity<>(areaPointList, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getBestAdPoint error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/transport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTransport() {
        List<WeightRoute> list;
        try {
            list = adService.getTransport();
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getTransport error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/shops", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getShops() {
        List<Shop> list;
        try {
            list = adService.getShops();
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getShops error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/shops/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getShops(@PathVariable String category) {
        List<Shop> list;
        try {
            list = adService.getShopsByCategory(category);
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getShops error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPeople() {
        List<People> list;
        try {
            list = adService.getPeople();
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getPeople error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/metro", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMetro() {
        List<Metro> list;
        try {
            list = adService.getMetro();
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getMetro error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

    @RequestMapping(value = "/houses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getHouses() {
        List<House> list;
        try {
            list = adService.getHouses();
            if (list != null)
                return new ResponseEntity<>(list, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (Exception e) {
            LOG.error("getHouses error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }


}


