# App Cadastrar Interesse

App Cadastrar Interesse é um aplicativo Android desenvolvido para cadastrar interesse em algum curso e visualizar sua lista de interesses.

## Destaques

- **Arquitetura MVC**: O aplicativo segue o padrão de arquitetura Model-View-Controller para organizar o código de maneira eficiente.
- **Shared Preferences**: Utilizado para armazenar e recuperar preferências do usuário, como o tema escuro.
- **Splash Screen**: Exibe uma tela de abertura com uma animação ou logotipo do aplicativo durante o carregamento inicial.
- **Room Database**: Armazena dados do aplicativo localmente, como informações de cursos.
- **RecyclerView**: Implementa uma lista rolável de cursos para uma experiência de usuário eficaz.

## Pré-requisitos

- Dispositivo Android com versão 7 ou posterior.
  
## Instalação

1. Clone este repositório: `git clone https://github.com/seu-usuario/seu-repositorio.git`.
2. Abra o projeto no Android Studio.
3. Aguarde a sincronização das dependências do Gradle.
4. Execute o aplicativo em um emulador ou dispositivo físico.

## Arquitetura

O aplicativo segue a arquitetura MV (Model-View) para uma organização eficiente do código. Ele é dividido nas seguintes camadas:

- **Model**: Inclui as classes de dados, entidades da Room DB e lógica de acesso a dados.
- **View**: Contém as atividades e fragmentos que compõem a interface do usuário.
- **ViewModel**: Responsável por fornecer dados para a interface do usuário e tratar a lógica de negócios.
- **Controller/Repository**: Atua como uma ponte entre a camada de Model e ViewModel, executando operações no banco de dados e fornecendo dados.

## Uso

Inserir Curso:
Preencha os campos com as informações do curso desejado.
Toque no botão "Salvar" para salvar as informações do curso.

Visualizar Cursos Salvos:
Ao cliclar no botão você verá a lista dos cursos que salvou.

Alternar Modo de Tema:
Você pode usar o interruptor para alternar entre os modos claro e escuro do aplicativo.

## Contribuição

Se deseja contribuir para o projeto, siga estas etapas:

1. Fork o projeto.
2. Crie sua ramificação de recurso (`git checkout -b feature/SeuRecurso`).
3. Commit suas alterações (`git commit -m 'Adicionar novo recurso'`).
4. Faça push para a ramificação (`git push origin feature/SeuRecurso`).
5. Abra uma solicitação pull.

## Autor

[Wallisson Martins] - [wallissonmartins37@gmail.com]
