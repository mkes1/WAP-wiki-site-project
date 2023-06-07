// Function to fetch and display page details
function fetchPageDetails() {
    // Fetch page details from the backend API
    fetch('/api/pages/{pageId}')
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
function fetchSectionDetails() {
    // Fetch section details from the backend API
    fetch('/api/sections/{sectionId}')
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
function fetchMediaFileDetails() {
    // Fetch media file details from the backend API
    fetch('/api/mediafiles/{mediafileId}')
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

// Function to fetch and display user details
function fetchUserDetails() {
    // Fetch user details from the backend API
    fetch('/api/users/{userId}')
        .then(response => response.json())
        .then(user => {
            // Update user details on the page
            document.getElementById('userId').textContent = user.id;
            document.getElementById('username').textContent = user.username;
            document.getElementById('userRole').textContent = user.role;
        })
        .catch(error => console.error('Error:', error));
}

// Call the fetch functions on page load
window.onload = function () {
    fetchPageDetails();
    fetchSectionDetails();
    fetchMediaFileDetails();
    fetchUserDetails();
};
