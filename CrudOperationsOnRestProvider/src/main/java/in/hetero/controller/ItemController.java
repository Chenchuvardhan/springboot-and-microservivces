package in.hetero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.hetero.bindings.ItemDto;
import in.hetero.service.IItemService;

@RestController
public class ItemController {
	@Autowired
	private IItemService itemService;
	@PostMapping(value="/saveitem",
			     consumes="application/json",
			     produces = "text/plain"
			)
	public ResponseEntity<String> saveItem(@RequestBody ItemDto itemDto) {
		ItemDto saveItem = itemService.saveItem(itemDto);
		return new ResponseEntity<>(saveItem+"--->item Saved", HttpStatus.CREATED);
	}

	@GetMapping(value="/getitems",
			    produces="application/json"
			    )
	public ResponseEntity<List<ItemDto>> RetrieveItems() {
    List<ItemDto> items = itemService.getItems();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	@PutMapping(value   ="/update",
			    consumes="application/json",
			    produces="text/plain"
			)
	public ResponseEntity<String> updateItem(@RequestBody ItemDto itemDto){
		System.out.println(itemDto);
		ItemDto saveItem = itemService.saveItem(itemDto);
		if(!itemDto.equals(saveItem))
		return new ResponseEntity<String>(saveItem+"---->item Updated",HttpStatus.OK);
	return new ResponseEntity<String>("item not updated",HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getitem/{id}",
			produces="application/json"
			)
    public ResponseEntity<ItemDto>  retrieveItem(@PathVariable int id){
    	ItemDto item = itemService.getItem(id);
    	if(!(item==null))
    	return new ResponseEntity<ItemDto>(item,HttpStatus.OK);
    	return new ResponseEntity<ItemDto>(item,HttpStatus.BAD_REQUEST);
    }
}
