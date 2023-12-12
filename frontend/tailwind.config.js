/** @type {import('tailwindcss').Config} */
export default {
  mode: 'jit',
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}'
  ],
  theme: {
    extend: {
      fontFamily: {
        bebas: ['Bebas Neue', 'sans-serif'],
        workSans: ['Work Sans', 'sans-serif'],
        poppins: ['Poppins', 'sans-serif']
      }
    },
    screens: {   	
      mobile: '375px',
      tablet: '768px',
      laptop: '1024px',
      desktop: '1440px'
    }
  },
  plugins: []
}
