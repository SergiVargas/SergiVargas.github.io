
const cards = document.querySelectorAll('.memory-card');


let hasFlipperCard = false;
let lockBoard = false;
let firstCard, secondCard;


function flipCards() {
  if(lockBoard) return;
  if(this === firstCard) return;

  this.classList.add('flip');

  //first click
  if(!hasFlipperCard){

    hasFlipperCard = true;
    firstCard = this;

    return;

  }
      //second click
    hasFlipperCard = false;
    secondCard = this;

    checkForMatch();

  
}

function checkForMatch(){
    
    let isMatch = firstCard.dataset.framework ===
    secondCard.dataset.framework;

    isMatch ? disableCards() : unflipCards();
    
}


function disableCards(){

    firstCard.removeEventListener('click', flipCards);
    secondCard.removeEventListener('click', flipCards);

    resetBoard();
}

function unflipCards(){

    lockBoard = true;

    setTimeout(() => {

        firstCard.classList.remove('flip');
        secondCard.classList.remove('flip');

        resetBoard();
    }, 300);

}

function resetBoard(){

    [hasFlipperCard, lockBoard] = [false, false];
    [firstCard, secondCard] = [null, null];
}

(function shuffle(){

    cards.forEach(card => {

        let randomPos = Math.floor(Math.random() * 12);
        card.style.order = randomPos;
    });

})();

cards.forEach(card => card.addEventListener('click', flipCards));
