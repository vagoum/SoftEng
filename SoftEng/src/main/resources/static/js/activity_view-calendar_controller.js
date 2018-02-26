

var Cal = function(element, y, m, d) {
  //Store div id
  this.htmlElement = element;

  // Days of week, starting on Sunday
  this.DaysOfWeek = [
    'Sun',
    'Mon',
    'Tue',
    'Wed',
    'Thu',
    'Fri',
    'Sat'
  ];

  // Months, stating on January
  this.Months = [
    'January', 
    'February', 
    'March', 
    'April', 
    'May', 
    'June', 
    'July', 
    'August', 
    'September', 
    'October', 
    'November', 
    'December'
  ];

  //Set the day, month, year
  this.month = m;
  this.year = y;
  this.day = d;
};

// Show month (year, month)
Cal.prototype.show = function() {

  var d = new Date()
  // First day of the week in the selected month
  , firstDayOfMonth = new Date(this.year, this.month, 1).getDay()
  // Last day of the selected month
  , lastDateOfMonth =  new Date(this.year, this.month+1, 0).getDate()
  // Last day of the previous month
  , lastDayOfLastMonth = this.month == 0 ? new Date(this.year-1, 11, 0).getDate() : new Date(this.year, this.month, 0).getDate();


  var html = '<table>';

  // Write selected month and year
  html += '<thead><tr>';
  html += '<td colspan="7">' + this.Months[this.month] + ' ' + this.year + '</td>';
  html += '</tr></thead>';


  // Write the header of the days of the week
  html += '<tr class="days">';
  for(var i=0; i < this.DaysOfWeek.length;i++) {
    html += '<td>' + this.DaysOfWeek[i] + '</td>';
  }
  html += '</tr>';
  console.log(this.day);

  // Write the days
  var i=1;
  do {
    var dow = new Date(this.year, this.month, i).getDay();  

    // If Sunday, start new row
    if ( dow == 0 ) {
      html += '<tr>';
    }
    // If not Sunday but first day of the month
    // it will write the last days from the previous month
    else if ( i == 1 ) {
      html += '<tr>';
      var k = lastDayOfLastMonth - firstDayOfMonth+1;
      for(var j=0; j < firstDayOfMonth; j++) {
        html += '<td class="not-current">' + k + '</td>';
        k++;
      }
    }

    // Write the current day in the loop
    var chkY = this.year
    var chkM = this.month

    if (chkY == this.year && chkM == this.month && i == this.day) {
      html += '<td class="today">' + i + '</td>';
    } else {
      html += '<td class="normal">' + i + '</td>';
    }
    // If Saturday, closes the row
    if ( dow == 6 ) {
      html += '</tr>';
    }
    // If not Saturday, but last day of the selected month
    // it will write the next few days from the next month
    else if ( i == lastDateOfMonth ) {
      var k=1;
      for(dow; dow < 6; dow++) {
        html += '<td class="not-current">' + k + '</td>';
        k++;
      }
    }

    i++;
  }while(i <= lastDateOfMonth);

  // Closes table
  html += '</table>';

  // Write HTML to the div
  //document.getElementById(this.divId).innerHTML = html;
  this.htmlElement.innerHTML = html;
};

// On Load of the window
window.onload = function() {
  // Start calendar
  var calendarElement = document.getElementById("calendar");
  var d = new Date();
  var calendar = new Cal(calendarElement, 
    calendarElement.getAttribute("data-year"), 
    calendarElement.getAttribute("data-month"), 
    calendarElement.getAttribute("data-day")); 
  calendar.show();      
}