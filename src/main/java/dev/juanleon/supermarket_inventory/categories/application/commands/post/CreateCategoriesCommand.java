package dev.juanleon.supermarket_inventory.categories.application.commands.post;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public record CreateCategoriesCommand (RequestCategoriesDto requestCategoriesDto) implements IRequest<ResponseRequestDto> {}
