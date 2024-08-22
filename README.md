<body>
    <h1>Documentação da API</h1>
    <p>Esta documentação descreve os endpoints disponíveis na API para autenticação e gerenciamento de decks.</p>
    
    <h2>Autenticação</h2>
    <div class="endpoint">
        <h3>POST /auth/login</h3>
        <p><strong>Descrição:</strong> Realiza o login e retorna um token JWT para autenticação.</p>
        <div class="request">
            <h4>Corpo da Requisição:</h4>
            <pre><code>
{
  "username": "seu_usuario",
  "password": "sua_senha"
}
            </code></pre>
        </div>
        <div class="response">
            <h4>Resposta:</h4>
            <pre><code>
{
  "token": "seu_token_jwt"
}
            </code></pre>
        </div>
    </div>
    
    <h2>Gestão de Decks</h2>
    <div class="endpoint">
        <h3>GET /decks/</h3>
        <p><strong>Descrição:</strong> Requer autenticação. Retorna todos os decks do usuário autenticado.</p>
        <div class="response">
            <h4>Resposta:</h4>
            <pre><code>
[
  {
    "id": 1,
    "name": "Deck Exemplo",
    "cards": [
      { "id": "card1", "name": "Card 1", "quantity": 2 },
      { "id": "card2", "name": "Card 2", "quantity": 1 }
    ]
  }
]
            </code></pre>
        </div>
    </div>
    
    <div class="endpoint">
        <h3>POST /decks/</h3>
        <p><strong>Descrição:</strong> Requer autenticação. Cria um novo deck para o usuário autenticado.</p>
        <div class="request">
            <h4>Corpo da Requisição:</h4>
            <pre><code>
{
  "name": "Novo Deck",
  "cards": [
    { "id": "card1", "quantity": 1 },
    { "id": "card2", "quantity": 2 }
  ]
}
            </code></pre>
        </div>
        <div class="response">
            <h4>Resposta:</h4>
            <pre><code>
{
  "id": 2,
  "name": "Novo Deck",
  "cards": [
    { "id": "card1", "name": "Card 1", "quantity": 1 },
    { "id": "card2", "name": "Card 2", "quantity": 2 }
  ]
}
            </code></pre>
        </div>
    </div>
    
    <div class="endpoint">
        <h3>PUT /decks/{id}</h3>
        <p><strong>Descrição:</strong> Requer autenticação. Atualiza um deck existente.</p>
        <div class="request">
            <h4>Corpo da Requisição:</h4>
            <pre><code>
{
  "name": "Deck Atualizado",
  "cards": [
    { "id": "card1", "quantity": 3 },
    { "id": "card3", "quantity": 1 }
  ]
}
            </code></pre>
        </div>
        <div class="response">
            <h4>Resposta:</h4>
            <pre><code>
{
  "id": 1,
  "name": "Deck Atualizado",
  "cards": [
    { "id": "card1", "name": "Card 1", "quantity": 3 },
    { "id": "card3", "name": "Card 3", "quantity": 1 }
  ]
}
            </code></pre>
        </div>
    </div>
    
    <div class="endpoint">
        <h3>DELETE /decks/{id}</h3>
        <p><strong>Descrição:</strong> Requer autenticação. Exclui um deck.</p>
        <div class="response">
            <h4>Resposta:</h4>
            <pre><code>
{
  "message": "Deck excluído com sucesso"
}
            </code></pre>
        </div>
    </div>
</body>
