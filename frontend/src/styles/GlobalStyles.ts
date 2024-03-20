import { createGlobalStyle } from 'styled-components';

export const GlobalStyles = createGlobalStyle`
    :root{
        --primary-color: #0f172a;
        --secondary-color: #1e293b;
        --contrast-color: #ffe815;
        //Box shadow
        --shadow-sm: 0 1px 2px rgba(0, 0, 0, 0.04); 
        --shadow-md: 0px 0.6rem 2.4rem rgba(0, 0, 0, 0.06);
        --shadow-lg: 0 2.4rem 3.2rem rgba(0, 0, 0, 0.12);

        //Border radius
        --border-radius-tiny: 3px;
        --border-radius-sm: 5px;
        --border-radius-md: 7px;
        --border-radius-lg: 9px;

        //Screen sizes
        --mobile: 480px;
        --tablet-size: 481px;
        --laptop: 769px;
        --desktop:1280px;


        --color-grey-0: #fff;
        --color-grey-50: #f9fafb;
        --color-grey-100: #f3f4f6;
        --color-grey-200: #e5e7eb;
        --color-grey-300: #d1d5db;
        --color-grey-400: #9ca3af;
        --color-grey-500: #6b7280;
        --color-grey-600: #4b5563;
        --color-grey-700: #374151;
        --color-grey-800: #1f2937;
        --color-grey-900: #111827;

    }
        ::-webkit-scrollbar {
            width: 15px;
        }

        /* Track */
        ::-webkit-scrollbar-track {
        background: #f1f1f1; 
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
        background: var(--contrast-color); 
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
        background: #555; 
        }
        *,
        *::before,
        *::after {
        box-sizing: border-box;
        padding: 0;
        margin: 0;

        /* Creating animations for dark mode */
        transition: background-color 0.3s, border 0.3s;
        }

        button {
        cursor: pointer;
        font-family: "Bebas Neue", sans-serif;

        }

        *:disabled {
        cursor: not-allowed;
        }
        body {
        font-family: "Inter", sans-serif;
        transition: color 0.3s, background-color 0.3s;
        min-height: 100vh;
        font-size: 1.rem;
        overflow-x:hidden;
     
        }
        main{
            overflow-x:hidden;
        }
     

        p {
        overflow-wrap: break-word;
        hyphens: auto;
        color:white;
        line-height: 1.1;
        }

        a {
        color: inherit;
        text-decoration: none;
        }

    ul {
        list-style: none;
        }
        p{
            font-size:20px;
            font-family: 'Inter', sans-serif;
        }
`;
