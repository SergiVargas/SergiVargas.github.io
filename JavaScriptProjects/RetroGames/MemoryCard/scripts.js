
const cards = document.querySelectorAll('.memory-card');

function flipCards() {
  this.classList.toggle('flip');
}

cards.forEach(card => card.addEventListener('click', flipCards));
