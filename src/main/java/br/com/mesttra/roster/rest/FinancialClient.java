package br.com.mesttra.roster.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.mesttra.roster.dto.ExpenseResponseDto;
import br.com.mesttra.roster.dto.ExpenseResquestDto;

@FeignClient(name = "financial", url="http://localhost:8081/api/v1")
public interface FinancialClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/financial", consumes = "application/json")
	ExpenseResponseDto addExpense(@RequestBody ExpenseResquestDto expenseRequestDto);

}
