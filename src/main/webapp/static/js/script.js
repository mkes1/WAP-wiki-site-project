/*jshint esversion: 6 */

function fetchPageDetails() {
  const urlParams = new URLSearchParams(window.location.search);
  const pageId = urlParams.get("page_id");
  // Fetch and display the list of pages
  fetch('/pages/${pageId}')
    .then(response => response.json())
    .then(page => {
         // Update section details on the page
        document.getElementById('pageTitle').textContent = page.title;
        document.getElementById('pageContent').textContent = page.content;
      })
    //.catch(error => console.error('Error:', error));
}

function fetchSectionDetails(sectionId) {
  const urlParams = new URLSearchParams(window.location.search);
  const sectionId = urlParams.get("section_id");
  // Fetch section details from the backend API
  fetch('/sections/${sectionId}')
    .then(response => response.json())
    .then(section => {
          // Update section details on the page
          document.getElementById('sectionTitle').textContent = section.title;
          document.getElementById('sectionContent').textContent = section.content;
    })
    //.catch(error => console.error('Error:', error));
}

// Fetch and display media file details
function fetchMediaFileDetails() {
    // Get the media file ID from the URL
    const urlParams = new URLSearchParams(window.location.search);
    const mediaFileId = urlParams.get("mediafile_id");
    // Fetch media file details from the backend API
    fetch('/mediafiles/${mediaFileId}')
        .then(response => response.json())
        .then(mediaFile => {
            // Update media file details on the page
            document.getElementById('filename').textContent = mediaFile.filename;
            document.getElementById('filetype').textContent = mediaFile.filetype;
            document.getElementById('url').textContent = mediaFile.url;
            document.getElementById('sectionId').textContent = mediaFile.sectionId;
        })
        //.catch(error => console.error('Error:', error));
};

// Call the fetch functions on page load
window.onload = function () {
  fetchPageDetails();
  fetchSectionDetails();
  fetchMediaFileDetails();
};