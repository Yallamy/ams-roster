package br.com.mesttra.roster.service;

import br.com.mesttra.roster.dto.ExpenseResponseDto;
import br.com.mesttra.roster.dto.ExpenseResquestDto;
import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.repository.PlayerRepository;
import br.com.mesttra.roster.rest.FinancialClient;
import feign.Feign;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
    	
    	FinancialClient financialClient = 
    			Feign.builder().target(FinancialClient.class, "http://localhost:8081/api/v1/financial");
    	
    	ExpenseResquestDto request = 
    			ExpenseResquestDto
    			.builder()
    			.amount(100d)
    			.dueDate(LocalDate.now())
    			.expenseType("SALARY")
    			.build();
    	
    	ExpenseResponseDto response = financialClient.addExpense(request);
    	
        return playerRepository.save(player);
    }

    @Transactional
    public void makePlayerUnavailable(Long playerId) {

        Player player = playerRepository.getById(playerId);
        player.setAvailable(false);
        playerRepository.save(player);

    }
}
