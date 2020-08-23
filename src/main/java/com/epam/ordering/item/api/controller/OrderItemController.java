package com.epam.ordering.item.api.controller;

import static com.epam.ordering.item.api.Constants.INVALID_INPUT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.ordering.item.api.Constants;
import com.epam.ordering.item.api.dto.OrderItemDto;
import com.epam.ordering.item.api.dto.Response;
import com.epam.ordering.item.api.dto.Result;
import com.epam.ordering.item.api.service.OrderItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Order-Item")
@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

	private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	private OrderItemService orderItemService;

	@ApiOperation("Add Order-Item details")
	@PostMapping(value = "/item", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<?> addOrderItem(
			@RequestBody @ApiParam(required = true, value = "Order-Item to be add") OrderItemDto orderItemDto) {

		if (orderItemDto != null) {
			Response<?> response = orderItemService.addOrderItem(orderItemDto);
			return new ResponseEntity<>(response.getResult(), response.getStatus());
		} else {
			log.error(Constants.INVALID_INPUT);
			return new ResponseEntity<>(new Result(INVALID_INPUT), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "API to fetch Order item based on Id")
	@GetMapping(value = "/{itemId}", produces = { "application/json" })
	public ResponseEntity<OrderItemDto> getDpModelInfo(
			@PathVariable(value = "itemId", required = true) @ApiParam(value = "itemId", required = true) int itemId) {
		OrderItemDto orderItemDto = null;
		try {
			orderItemDto = orderItemService.getOrderItem(itemId);
			return new ResponseEntity<>(orderItemDto,HttpStatus.OK);
		} catch(Exception e) {
			log.error(Constants.INVALID_INPUT+e.getMessage());
			return new ResponseEntity<>(orderItemDto,HttpStatus.BAD_REQUEST);
		}
		
	}
}
