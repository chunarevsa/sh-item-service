package com.smarthome.shitemservice.service

import com.smarthome.shitemservice.dto.CreateItemRequest
import com.smarthome.shitemservice.dto.UpdateItemRequest
import com.smarthome.shitemservice.entity.Item
import com.smarthome.shitemservice.exception.NotFoundException
import com.smarthome.shitemservice.repo.ItemRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {

    fun getItem(itemId: Long): Optional<Item> = itemRepository.findById(itemId)

    fun createItem(req: CreateItemRequest): Item {
        val item = Item().apply {
            this.isActive = true
            this.ownerId = req.ownerId
            this.name = req.name
            this.description = req.description
            this.characteristics = req.characteristics
            this.imageUrl = req.imageUrl
            this.instructionUrl = req.instructionUrl
        }
        return itemRepository.save(item)
    }

    fun updateItem(itemId: Long, req: UpdateItemRequest): Item {
        val item = findItem(itemId)
        req.name.let { item.name = it }
        req.description.let { item.description = it }
        req.characteristics.let { item.characteristics = it }
        req.imageUrl.let { item.imageUrl = it }
        req.instructionUrl.let { item.instructionUrl = it }

        return itemRepository.save(item)
    }

    fun deactivateItem(itemId: Long) {
        val item = findItem(itemId)
        item.isActive = false
        itemRepository.save(item)
    }

    fun checkAvailability(itemId: Long): Boolean {
        val item = itemRepository.findById(itemId)
        return item.isPresent && item.get().isActive
    }

    fun bookItems(itemId: Long, amount: Long ,userId: Long) {
        val item = findItem(itemId)
        // TODO: Just do it

    }

    private fun findItem(itemId: Long) =
        itemRepository.findById(itemId).map { it }.orElseThrow { NotFoundException("item", itemId.toString()) }

}