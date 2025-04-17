package in.hetero.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hetero.bindings.ItemDto;
import in.hetero.entity.Item;
import in.hetero.repository.ItemRepository;

@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private ItemRepository itemRepo;

	@Override
	public ItemDto saveItem(ItemDto itemDto) {
		Item item=new Item();
		BeanUtils.copyProperties(itemDto,item);
	    Item save = itemRepo.save(item);
	    ItemDto itemDtoReturn=new ItemDto();
	    BeanUtils.copyProperties(save,itemDtoReturn);
		return itemDtoReturn;
	}

	@Override
	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		Optional<Item> byId = itemRepo.findById(id);
		if(byId.isPresent()) {
		itemRepo.deleteById(id);
		return true;
		}
		return false;
	}

	@Override
	public ItemDto getItem(int id) {
		// TODO Auto-generated method stub
		Optional<Item> byId = itemRepo.findById(id);
		ItemDto itemDto=new ItemDto();
		if(byId.isPresent()) {
		Item item = byId.get();
		BeanUtils.copyProperties(item,itemDto);
		return itemDto;
		}
		return null;
	}

	@Override
	public List<ItemDto> getItems() {
		// TODO Auto-generated method stub
		List<Item> all = itemRepo.findAll();
		List<ItemDto> list=new ArrayList<>();
		for(Item item:all) {
	        ItemDto itemDto=new ItemDto();
			BeanUtils.copyProperties(item,itemDto);
			list.add(itemDto);
		}
		return list;
	}

}
