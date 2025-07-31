package com.outeseratest.raspberry.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outeseratest.raspberry.aplication.usecase.CalculateIntervalsUseCase;
import com.outeseratest.raspberry.domain.model.IntervalResult;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/awards")
@Tag(name = "Awards", description = "Operações relacionadas ao intervalo de prêmios dos produtores do franboesa")
@RequiredArgsConstructor
public class ProducerIntervalController {

    private final CalculateIntervalsUseCase useCase;

    @GetMapping("/producers/intervals")
    @Operation(
        summary = "Retorna produtores com maior e menor intervalo entre vitórias",
        description = "Calcula os produtores que tiveram o menor e maior intervalo entre vitórias consecutivas na categoria Pior Filme"
    )
    @ApiResponse(responseCode = "200", description = "Intervalos calculados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno ao processar o cálculo")
    public ResponseEntity<IntervalResult> getIntervalStats() {
        IntervalResult resultado = useCase.execute();
        return ResponseEntity.ok(resultado);
    }
}
