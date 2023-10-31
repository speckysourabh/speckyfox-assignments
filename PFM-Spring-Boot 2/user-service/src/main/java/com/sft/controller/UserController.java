package com.sft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sft.dto.UserBudgetDTO;
import com.sft.entity.UserEntity;
import com.sft.entity.external.BudgetEntity;
import com.sft.entity.external.TransactionEntity;
import com.sft.service.BudgetService;
import com.sft.service.JwtService;
import com.sft.service.TransactionService;
import com.sft.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BudgetService budgetService;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable Long userId) throws Exception {
		UserEntity user = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser() {
		List<UserEntity> users = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PostMapping("/create")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
		UserEntity user = userService.addUser(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@GetMapping("/budgets/{userId}")
	public ResponseEntity<UserBudgetDTO> getUserBudgets(@PathVariable Long userId) throws Exception {
		UserEntity user = userService.getUser(userId);
		List<BudgetEntity> budgetEntity = budgetService.getAllBudget(userId);
		UserBudgetDTO budgetDTO = new UserBudgetDTO();
		budgetDTO.setBudgets(budgetEntity);
		budgetDTO.setUserEntity(user);
		return ResponseEntity.status(HttpStatus.OK).body(budgetDTO);
	}

	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody UserEntity userEntity) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getEmail(), userEntity.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(userEntity.getEmail());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

	@PostMapping("/transactions")
	public ResponseEntity<TransactionEntity> addTransaction(@RequestBody TransactionEntity transactionEntity)
			throws Exception {
		TransactionEntity transaction = transactionService.addTransaction(transactionEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
	}

	@GetMapping("/transactions/{userId}")
	public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long userId) {
		List<TransactionEntity> transaction = transactionService.getAllTransaction(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
	}

	@PostMapping("/budgets")
	public ResponseEntity<BudgetEntity> addBudget(@RequestBody BudgetEntity BudgetEntity) {
		BudgetEntity budget = budgetService.addBudget(BudgetEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(budget);
	}

}
