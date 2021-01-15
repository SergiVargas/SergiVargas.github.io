
const cards = document.querySelectorAll('.memory-card');


let hasFlipperCard = false;
let firstCard, secondCard;


function flipCards() {
  this.classList.add('flip');

  //first click
  if(!hasFlipperCard){

    hasFlipperCard = true;
    firstCard = this;

  }else{
      //second click
      hasFlipperCard = false;
      secondCard = this;
  }
}

cards.forEach(card => card.addEventListener('click', flipCards));
