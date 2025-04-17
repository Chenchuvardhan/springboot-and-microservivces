package in.hetero.service;

import java.util.List;

import in.hetero.bindings.ItemDto;

public interface IItemService {
public abstract ItemDto saveItem(ItemDto itemdto);
public abstract boolean deleteItem(int id);
public abstract ItemDto getItem(int id);
public abstract List<ItemDto> getItems();
}
