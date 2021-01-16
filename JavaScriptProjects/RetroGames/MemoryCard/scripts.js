
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


      if (firstCard.dataset.framework ===
         secondCard.dataset.framework){

        firstCard.removeEventListener('click', flipCards);
        secondCard.removeEventListener('click', flipCards);
         }else{

            setTimeout(() => {

                firstCard.classList.remove('flip');
                secondCard.classList.remove('flip');

            }, 300);

            
         }
  }
}

cards.forEach(card => card.addEventListener('click', flipCards));
