package com.epam.ordering.item.api.service;

import static com.epam.ordering.item.api.Constants.INVALID_QUANTITY;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epam.ordering.item.api.dataaccess.OrderItemRepository;
import com.epam.ordering.item.api.dto.OrderItemDto;
import com.epam.ordering.item.api.dto.Response;
import com.epam.ordering.item.api.dto.Result;
import com.epam.ordering.item.api.entity.OrderItem;

import org.modelmapper.ModelMapper;

@Service
public class OrderItemService {

	private static final Logger log = LoggerFactory.getLogger(OrderItemService.class);
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	public Response<?> addOrderItem(OrderItemDto orderItemDto) {
		Response<?> response;
		if(orderItemDto.getQuantity()>0) {
			OrderItem orderItem =orderItemRepository.save(new OrderItem(orderItemDto.getProductCode(), orderItemDto.getProductName(), orderItemDto.getQuantity()));
			response = new Response<>(new Result("Item Saved Successfully, Order itemId: "+orderItem.getId()), HttpStatus.OK);
		}else {
			response = new Response<>(new Result(INVALID_QUANTITY.getCode()), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	public OrderItemDto getOrderItem(int itemId) {
		OrderItemDto orderItemDto=null;;
		Optional<OrderItem> orderItem =orderItemRepository.findById(itemId);
		if(orderItem.isPresent()) {
			log.debug("Order Item details available for itemId: {}",itemId);
			orderItemDto= modelMapper.map(orderItem.get(), OrderItemDto.class);
		}
		else {
			log.debug("Order Item not available for itemId: {}",itemId);
		}
		return orderItemDto;
	}
	
}
