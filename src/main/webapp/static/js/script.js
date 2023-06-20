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

// Call the fetchPageDetails function on page load
window.onload = fetchPageDetails;