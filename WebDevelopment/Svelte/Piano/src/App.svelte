<script>
	function sonido(numero){

		const audio = new Audio();
		audio.src = 'asset/sounds/' + numero + '.wav';
		audio.load();
		audio.play();
	}
</script>

<main>
	<div class = "row">
		<div class = "col-lg-6">
			<div clas = "list-group">
				<div on:click={ () => sonido(1) } class="list-group-item list-group-item-action" style = "background-color: red"></div>
				<div on:click={ () => sonido(2) } class="list-group-item list-group-item-action" style = "background-color: orange"></div>
				<div on:click={ () => sonido(3) } class="list-group-item list-group-item-action" style = "background-color: green"></div>
				<div on:click={ () => sonido(4) } class="list-group-item list-group-item-action" style = "background-color: yellow"></div>
				<div on:click={ () => sonido(5) } class="list-group-item list-group-item-action" style = "background-color: grey"></div>
				<div on:click={ () => sonido(6) } class="list-group-item list-group-item-action" style = "background-color: blue"></div>
			</div>
		</div>
	</div>

</main>

<style>
	.list-group-item{

		cursor: pointer;
		height: 50px;
	}

	.row{

		display : flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
	}

	.list-group-item:active{

		opacity: 0.5;

	}

	main{

		background-color: darkkhaki;
	}
</style>