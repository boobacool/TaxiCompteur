/**
 * 
 */
$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		$.get(href,function(mois,status){
			$('.myForm #id').val(mois.id);
			$('.myForm #libelle').val(mois.libelle);
		});
		$('.myForm #exampleModal').modal();
	});
	
	$('.nBtn').on('click',function(event){
		event.preventDefault();
		$('.myForm #id').val('');
		$('.myForm #libelle').val('');
		$('.myForm #exampleModal').modal();
	});
	
	$('.table .sBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#modalSupp #delRef').attr('href',href)
		$('#modalSupp').modal();
	});
});