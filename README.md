# Java Persistence
Projeto da disciplina persistence - MBA FIAP



## Rodar o projeto
Para rodar o projeto basta executar o script *run.sh*
```
./run.sh
```

## Acessar  a aplicação

- Acesse a aplicação na URL -> `http://localhost:8000/swagger-ui.html`

## JSON Exemplos

- product-controller
```
	{
		"name": "TV",
		"amount": 10,
		"price": 7500.00
	}
```

- customer-controller
```
	{
		"cpf": 12345678,
		"name": "Nome Teste",
		"email": "teste@gmail.com",
		"gender": "M",
		"username": "teste.teste",
		"address": [
			{
				"cep": "12345-123",
				"state": "MG",
				"description": "Apto"
			}
		],
		"orders": []
	}
```

- address-controller
```
	{
		"cep": "06056-111",
		"state": "RS",
		"description": "Sul"
	}
```

- orders-controller POST
```
	{
		"totalPrice": 2000.50,
		"customer": 
		{
			"cpf": 11111111111,
			"name": "Cesar d",
			"email": "lira@gmail.com",
			"gender": "M",
			"username": "mmmmm",
			"orders": [],
			"address": [
				{
					"cep": "06056-140",
					"state": "SP",
					"description": "Casa"
				}	
			]
		},
		"products": [
			{
				"id": 1,
				"name": "Celular",
				"amount": 10,
				"price": 2000.00,
				"orders": []
			},
			{
				"id": 2,
				"name": "Impressora",
				"amount": 10,
				"price": 600.00,
				"orders": []
			}
		]
	}
```