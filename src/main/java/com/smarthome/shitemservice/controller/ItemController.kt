package com.smarthome.shitemservice.controller

import com.smarthome.shitemservice.dto.CreateItemRequest
import com.smarthome.shitemservice.dto.UpdateItemRequest
import com.smarthome.shitemservice.entity.Item
import com.smarthome.shitemservice.service.ItemService
import com.smarthome.shitemservice.util.HeaderUtil
import com.smarthome.shitemservice.util.ResponseUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/item")
class ItemController(
    private val itemService: ItemService,
    @Value("\${spring.application.name}")
    private val applicationName: String
) {
    private val log: Logger = LoggerFactory.getLogger(ItemController::class.java)

    private val ENTITY_NAME = "item"

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<Item> {
        log.debug("REST request to get $ENTITY_NAME : {}", id)
        return ResponseUtil.wrapOrNotFound(itemService.getItem(id))
    }

    // TODO add @Valid
    @PostMapping("/create")
    fun createItem(@RequestBody req: CreateItemRequest): ResponseEntity<Item> {
        log.debug("REST request to create $ENTITY_NAME : {}", req)
        val user = itemService.createItem(req)
        return ResponseEntity.created(URI("/api/user/${user.id}"))
            .headers(
                HeaderUtil.createEntityCreationAlert(
                    applicationName, false, ENTITY_NAME, user.id.toString()
                )
            )
            .body(user)
    }

    @PostMapping("/{id}/update")
    fun updateITem(@PathVariable id: Long, @RequestBody req: UpdateItemRequest): ResponseEntity<Item> {
        log.debug("REST request to update $ENTITY_NAME : {}", req)
        val user = itemService.updateItem(id, req)
        return ResponseEntity.ok()
            .headers(
                HeaderUtil.createEntityUpdateAlert(
                    applicationName, false, ENTITY_NAME, user.id.toString()
                )
            )
            .body(user)
    }

    @PostMapping("/{id}/deactivate")
    fun deactivate(@PathVariable id: Long): ResponseEntity<Void> {
        log.debug("REST request to deactivate $ENTITY_NAME : {}", id)
        itemService.deactivateItem(id)
        return ResponseEntity.noContent()
            .headers(
                HeaderUtil.createEntityDeactivationAlert(
                    applicationName, false, ENTITY_NAME, id.toString()
                )
            ).build()
    }

    @GetMapping("/{id}/check-availability")
    fun checkAvailability(@PathVariable id: Long): Boolean {
        log.debug("REST request to check availability $ENTITY_NAME : {}", id)
        return itemService.checkAvailability(id)
    }


}