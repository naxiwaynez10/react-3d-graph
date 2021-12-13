const path = require('path');
const { styles } = require( '@ckeditor/ckeditor5-dev-utils' );

module.exports = {
  entry: path.resolve(__dirname, 'src/js', 'index.js'),
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'index.bundle.js',
  },
  module: {
    rules: [
      {
        test: /ckeditor5-[^/\\]+[/\\]theme[/\\]icons[/\\][^/\\]+\.svg$/,
        use: [ 'raw-loader' ]
      },
      {
        test: /ckeditor5-[^/\\]+[/\\]theme[/\\].+\.css/,
        use: [
          {
            loader: require.resolve('style-loader')
          },
          {
            loader: require.resolve('postcss-loader'),
            options: styles.getPostCssConfig( {
              themeImporter: {
                themePath: require.resolve( '@ckeditor/ckeditor5-theme-lark' )
              },
              minify: true
            } )
          }
        ]
      },
    ]
  }
};
