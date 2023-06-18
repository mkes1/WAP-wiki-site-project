/*jshint esversion: 6 */

function fetchPageDetails() {
  // Fetch and display the list of pages
  fetch('/pages')
    .then(response => response.json())
    .then(pages => {
      var pagesList = document.getElementById('pagesList');

      pages.forEach(page => {
        var pageLink = document.createElement('a');
        pageLink.href = page.html?page_id=${page.id};
        pageLink.textContent = page.title;

        var listItem = document.createElement('li');
        listItem.appendChild(pageLink);

        pagesList.appendChild(listItem);
      });
    })
    //.catch(error => console.error('Error:', error));
}

// Function to fetch and display section details
function fetchSectionDetails() {
  // Fetch section details from the backend API
  fetch('/sections/{section_id}')
    .then(response => response.json())
    .then(section => {
      // Update section details on the page
      document.getElementById('sectionTitle').textContent = section.title;
      document.getElementById('sectionContent').textContent = section.content;
    })
    //.catch(error => console.error('Error:', error));
}



// Call the fetch functions on page load
window.onload = function () {
  fetchPageDetails();
  fetchSectionDetails();

};