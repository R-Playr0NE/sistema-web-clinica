//botãa tema claro e escuro

// Função chamada ao clicar no botão
function applyTheme() {
    const body = document.getElementById("body");

    // Alterna a classe
    body.classList.toggle("dark-mode");

    // Salva no localStorage
    if (body.classList.contains("dark-mode")) {
        localStorage.setItem("theme", "dark");
    } else {
        localStorage.setItem("theme", "light");
    }

    updateButtons();
}

// Aplica o tema salvo ao carregar qualquer página
function loadTheme() {
    const body = document.getElementById("body");
    const savedTheme = localStorage.getItem("theme");

    if (savedTheme === "dark") {
        body.classList.add("dark-mode");
    } else {
        body.classList.remove("dark-mode");
    }

    updateButtons();
}

// Atualiza o estado visual dos botões
function updateButtons() {
    const lightBtn = document.getElementById("btn-light-mode");
    const darkBtn = document.getElementById("btn-dark-mode");

    // Se a página não tem o botão de tema, apenas não atualiza nada.
    if (!lightBtn || !darkBtn) return;

    const isDark = document.getElementById("body").classList.contains("dark-mode");

    lightBtn.classList.toggle("active", !isDark);
    darkBtn.classList.toggle("active", isDark);
}

// Rodar ao carregar a página
window.onload = loadTheme;