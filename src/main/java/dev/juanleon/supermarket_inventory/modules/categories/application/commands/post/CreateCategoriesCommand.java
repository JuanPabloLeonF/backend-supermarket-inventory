package dev.juanleon.supermarket_inventory.modules.categories.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record CreateCategoriesCommand (RequestCategoriesDto requestCategoriesDto) implements IRequest<ResponseRequestDto> {}
