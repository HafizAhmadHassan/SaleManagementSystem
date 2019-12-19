function help_clicked()
{
    $('html, body').animate({
        scrollTop: $("#footer_help").offset().top
    }, 2000);



}
var enabled = 0
      function toggler_collapser()
      {
        $('#collapse_menu').collapse('toggle')
        if (enabled==0)
        {
          $('#homer').css({
          'background-color': '#cc0000',
          'color': 'white'
      });
          enabled=1
        }
        else
        {
          enabled = 0
          $('#homer').css({
          'background-color': 'rgba(255,255,255,0.4)',
          'color': 'black'
      });
        }

      }

$(document).ready(function() {
    $("body").css("display", "none");
 
    $("body").fadeIn(2000);
 
    $("a.transition").click(function(event){
        event.preventDefault();
        linkLocation = this.href;
        $("body").fadeOut(1000, redirectPage);      
    });
         
    function redirectPage() {
        window.location = linkLocation;
    }
});