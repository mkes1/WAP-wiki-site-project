// Function to fetch and display page details
function fetchPageDetails(pageId) {
    // Fetch page details from the backend API
    fetch('/pages/' + pageId)
        .then(response => response.json())
        .then(page => {
            // Update page details on the page
            document.getElementById('pageId').textContent = page.id;
            document.getElementById('pageTitle').textContent = page.title;
            document.getElementById('pageContent').textContent = page.content;
            document.getElementById('pageSectionId').textContent = page.sectionId;
        })
        .catch(error => console.error('Error:', error));
}

// Function to fetch and display section details
function fetchSectionDetails(sectionId) {
    // Fetch section details from the backend API
    fetch('/sections/' + sectionId)
        .then(response => response.json())
        .then(section => {
            // Update section details on the page
            document.getElementById('sectionId').textContent = section.id;
            document.getElementById('sectionTitle').textContent = section.title;
            document.getElementById('sectionParentId').textContent = section.parentId;
        })
        .catch(error => console.error('Error:', error));
}

// Function to fetch and display media file details
function fetchMediaFileDetails(mediafileId) {
    // Fetch media file details from the backend API
    fetch('/mediafiles/' + mediafileId)
        .then(response => response.json())
        .then(mediafile => {
            // Update media file details on the page
            document.getElementById('mediafileId').textContent = mediafile.id;
            document.getElementById('mediafileTitle').textContent = mediafile.title;
            document.getElementById('mediafileType').textContent = mediafile.type;
            document.getElementById('mediafileUrl').textContent = mediafile.url;
        })
        .catch(error => console.error('Error:', error));
}

// Call the fetch functions on page load
window.onload = function () {
    const pageId = 1; // Replace with the actual page ID
    const sectionId = 1; // Replace with the actual section ID
    const mediafileId = 1; // Replace with the actual media file ID
    const userId = 1; // Replace with the actual user ID

    fetchPageDetails(pageId);
    fetchSectionDetails(sectionId);
    fetchMediaFileDetails(mediafileId);
    fetchUserDetails(userId);
};