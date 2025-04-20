package org.example.paymentservice.controller

import jakarta.websocket.server.PathParam
import org.example.paymentservice.repository.model.view.ViewCapital
import org.example.paymentservice.service.CapitalService
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("v1/user/capitals")
class CapitalController (private val capitalService: CapitalService) {

    @GetMapping
    fun getCapital(@PathParam("userId") userId: UUID): List<ViewCapital> =
        capitalService.getCapital(userId)

    @PostMapping
    fun createCapital(
        @RequestBody listViewCapital: List<ViewCapital>): List<ViewCapital> =
        capitalService.createListCapital(listViewCapital[0].user_id, listViewCapital)

    @PutMapping("{capitalId}")
    fun updateCapital(
        @PathVariable("capitalId") capitalId: Long,
        @RequestBody viewCapital: ViewCapital): ViewCapital? =
        capitalService.updateCapital(viewCapital.user_id, capitalId, viewCapital)
}