$('#send').on('click', sendMessage);

function sendMessage() {
  var textVal = $('textarea').val();
    if( $('textarea').val() !== '') {
       console.log( $('textarea').val() );
       $('textarea').val('');
       var message = $('<div>' + textVal + '</div>');
       message.addClass('my-bubble');
       $('.chatbox').append(message);
    } else {
       console.log("비어있음");
    }
}
