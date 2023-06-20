function fetchPageDetails() {
    // Fetch and display the list of pages
    fetch('/pages')
        .then(response => response.json())
        .then(pages => {
            var pagesList = document.getElementById('pagesList');

            pages.forEach(page => {
                var pageLink = document.createElement('a');
                pageLink.href = 'page.html/?id=' + page.id;
                pageLink.textContent = page.title;

                var listItem = document.createElement('li');
                listItem.appendChild(pageLink);

                pagesList.appendChild(listItem);
            });
        })
        //.catch(error => console.error('Error:', error));
}

function fetchSectionDetails() {
              // Fetch and display the list of sections
              fetch('/sections')
                .then(response => response.json())
                .then(sections => {
                  var sectionsList = document.getElementById('sectionsList');

                  sections.forEach(section => {
                    var sectionLink = document.createElement('a');
                    sectionLink.href = 'section.html/?id=' + section.id;
                    sectionLink.textContent = section.title;

                    var listItem = document.createElement('li');
                    listItem.appendChild(sectionLink);

                    sectionsList.appendChild(listItem);
                  });
                })
                //.catch(error => console.error('Error:', error));
            }
window.onload = function () {
    fetchPageDetails();
    fetchSectionDetails();
   };


