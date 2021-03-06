import CKEditor from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-editor-classic/src/classiceditor';
import Essentials from '@ckeditor/ckeditor5-essentials/src/essentials';
import UploadAdapter from '@ckeditor/ckeditor5-adapter-ckfinder/src/uploadadapter';
import Autoformat from '@ckeditor/ckeditor5-autoformat/src/autoformat';
import Bold from '@ckeditor/ckeditor5-basic-styles/src/bold';
import Italic from '@ckeditor/ckeditor5-basic-styles/src/italic';
import BlockQuote from '@ckeditor/ckeditor5-block-quote/src/blockquote';
import CKFinder from '@ckeditor/ckeditor5-ckfinder/src/ckfinder';
import EasyImage from '@ckeditor/ckeditor5-easy-image/src/easyimage';
import Heading from '@ckeditor/ckeditor5-heading/src/heading';
import Image from '@ckeditor/ckeditor5-image/src/image';
import ImageCaption from '@ckeditor/ckeditor5-image/src/imagecaption';
import ImageStyle from '@ckeditor/ckeditor5-image/src/imagestyle';
import ImageToolbar from '@ckeditor/ckeditor5-image/src/imagetoolbar';
import ImageUpload from '@ckeditor/ckeditor5-image/src/imageupload';
import Link from '@ckeditor/ckeditor5-link/src/link';
import List from '@ckeditor/ckeditor5-list/src/list';
import MediaEmbed from '@ckeditor/ckeditor5-media-embed/src/mediaembed';
import Paragraph from '@ckeditor/ckeditor5-paragraph/src/paragraph';
import PasteFromOffice from '@ckeditor/ckeditor5-paste-from-office/src/pastefromoffice';
import Table from '@ckeditor/ckeditor5-table/src/table';
import TableToolbar from '@ckeditor/ckeditor5-table/src/tabletoolbar';
import RealTimeCollaborativeEditing from '@ckeditor/ckeditor5-real-time-collaboration/src/realtimecollaborativeediting';
import RealTimeCollaborativeComments from '@ckeditor/ckeditor5-real-time-collaboration/src/realtimecollaborativecomments';
import RealTimeCollaborativeTrackChanges from '@ckeditor/ckeditor5-real-time-collaboration/src/realtimecollaborativetrackchanges';
import PresenceList from '@ckeditor/ckeditor5-real-time-collaboration/src/presencelist';
import Autosave from '@ckeditor/ckeditor5-autosave/src/autosave';
import WordCount from '@ckeditor/ckeditor5-word-count/src/wordcount';

import { Graph } from 'react-d3-graph';

window.CKEditor = CKEditor;
window.ClassicEditor = ClassicEditor;
window.Essentials = Essentials;
window.UploadAdapter = UploadAdapter;
window.Autoformat = Autoformat;
window.Bold = Bold;
window.Italic = Italic;
window.BlockQuote = BlockQuote;
window.CKFinder = CKFinder;
window.EasyImage = EasyImage;
window.Heading = Heading;
window.Image = Image;
window.ImageCaption = ImageCaption;
window.ImageStyle = ImageStyle;
window.ImageToolbar = ImageToolbar;
window.ImageUpload = ImageUpload;
window.Link = Link;
window.List = List;
window.MediaEmbed = MediaEmbed;
window.Paragraph = Paragraph;
window.PasteFromOffice = PasteFromOffice;
window.Table = Table;
window.TableToolbar = TableToolbar;
window.RealTimeCollaborativeEditing = RealTimeCollaborativeEditing;
window.RealTimeCollaborativeComments = RealTimeCollaborativeComments;
window.RealTimeCollaborativeTrackChanges = RealTimeCollaborativeTrackChanges;
window.PresenceList = PresenceList;
window.Autosave = Autosave;
window.WordCount = WordCount;

window.Graph = Graph;
